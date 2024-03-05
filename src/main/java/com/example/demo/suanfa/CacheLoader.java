package com.example.demo.suanfa;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CacheLoader {
    public static int CACHESIZE = 512* 1024;
    static FileCache fileCache = new FileCache(CACHESIZE);

    public static void main(String[] args) {
        byte[] contents = getFromRemote();
        Integer index = 10;
        String s = "hello world";
        s.getBytes();
        fileCache.put(index, "hello world".getBytes(StandardCharsets.UTF_8));
        //do some thing;
        Byte[] bytes = fileCache.get(11, 20);
        System.out.println(bytes);

    }

    public static byte[] getFromRemote() {
        return null;
    }

    public static class FileCache {
        private byte[] cache;
        public FileCache(int cacheSize) {
            cache = new byte[cacheSize];
        }

        public Byte[] get(int index, int length) {
            List<Byte> list = new ArrayList<Byte>();
            for (int i = index; i < index + length; i++) {
                if (cache[i] == 0) {
                    continue;
                }
                list.add(cache[i]);
            }
            return list.toArray(new Byte[list.size()]);
        }

        public void put(int index, byte[] contents) {
            if (index > CACHESIZE) {
                throw new RuntimeException("invalid cache size");
            }
            for (int i = index; i < index + contents.length; i++) {
                cache[i] = contents[i-index];
            }
        }

    }
}
