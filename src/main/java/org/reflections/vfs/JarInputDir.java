package org.reflections.vfs;

import kotlin.collections.AbstractIterator;
import org.reflections.ReflectionsException;
import org.reflections.util.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

/**
 *
 */
public class JarInputDir implements Vfs.Dir {
    private final URL url;
    JarInputStream jarInputStream;
    long cursor = 0;
    long nextCursor = 0;

    public JarInputDir(URL url) {
        this.url = url;
    }

    public String getPath() {
        return url.getPath();
    }

    public Iterable<Vfs.File> getFiles() {
        return new Iterable<Vfs.File>() {
            public Iterator<Vfs.File> iterator() {
                return new AbstractIterator<Vfs.File>() {

                    {
                        try { jarInputStream = new JarInputStream(url.openConnection().getInputStream()); }
                        catch (Exception e) { throw new ReflectionsException("Could not open url connection", e); }
                    }

                    protected void computeNext() {
                        while (true) {
                            try {
                                ZipEntry entry = jarInputStream.getNextJarEntry();
                                if (entry == null) {
                                    return;
                                }

                                long size = entry.getSize();
                                if (size < 0) size = 0xffffffffl + size; //JDK-6916399
                                nextCursor += size;
                                if (!entry.isDirectory()) {
                                    setNext(new JarInputFile(entry, JarInputDir.this, cursor, nextCursor));
                                }
                            } catch (IOException e) {
                                throw new ReflectionsException("could not get next zip entry", e);
                            }
                        }
                    }
                };
            }
        };
    }

    public void close() {
        Utils.close(jarInputStream);
    }
}
