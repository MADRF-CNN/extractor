import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class getDex {
    public static void main(String[] args) throws IOException {
        for (int i = 1080; i < 2008; i++) {
            String zipPath = "D:\\dataset\\Mal\\" + i + ".apk";
            String outPath = "F:\\OUT\\" + i;

            File file = new File(zipPath);
            if (!file.isFile()) {
                throw new FileNotFoundException("file not exist!");
            }
            if (outPath == null || "".equals(outPath)) {
                outPath = file.getParent();
            }
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> files = zipFile.entries();
            ZipEntry entry = null;
            File outFile = null;
            BufferedInputStream bin = null;
            BufferedOutputStream bout = null;
            while (files.hasMoreElements()) {
                entry = files.nextElement();
                outFile = new File(outPath + File.separator + entry.getName());
                if (entry.isDirectory()) {
                    outFile.mkdirs();
                    continue;
                }
                if (!outFile.getParentFile().exists()) {
                    outFile.getParentFile().mkdirs();
                }
                outFile.createNewFile();
                if (!outFile.canWrite()) {
                    continue;
                }
                try {
                    bin = new BufferedInputStream(zipFile.getInputStream(entry));
                    bout = new BufferedOutputStream(new FileOutputStream(outFile));
                    byte[] buffer = new byte[1024];
                    int readCount = -1;
                    while ((readCount = bin.read(buffer)) != -1) {
                        bout.write(buffer, 0, readCount);
                    }
                } finally {
                    try {
                        bin.close();
                        bout.flush();
                        bout.close();
                    } catch (Exception e) {
                    }
                }
            }
            System.out.println(i + " apk complete");
        }

        for (int i = 1; i < 2008; i++) {
            String path = "F:\\OUT\\" + i;
            File file = new File(path);
            File[] fs = file.listFiles();
            for (File f : fs) {
                if (f.isDirectory())
                    deleteDir(f);
                if (!f.getName().endsWith("dex"))
                    f.delete();
            }
            System.out.println(i+ "  complete");
        }
    }

    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
