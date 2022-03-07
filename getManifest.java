import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.exception.ParserException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class getManifest {
    public static void main(String[] args) throws IOException {
        String legPath = "G:\\119\\";
        String malPath = "G:\\dataset\\mal_train_all_1\\";
        String malOutPath = "G:\\dataset\\mal_manifest\\";
        String legOutPath = "G:\\119\\leg_manifest\\";
        for (int i = 1; i < 2008; i++) {
            String path = legPath + i + ".apk";
            String out = legOutPath + i + ".txt";
//            String path = legPath + i + ".apk";
//            String out = legOutPath + i + ".txt";
            if (manifestGet(path, out)){
                System.out.println(i+"  complete");
            } else {
                File file = new File(out);
                file.createNewFile();
            }
        }
    }

    public static boolean manifestGet(String path, String outpath) throws IOException {
        try {
            ApkFile apkFile = new ApkFile(new File(path));
            String manifestXml = apkFile.getManifestXml();
            FileWriter fwriter = null;
            fwriter = new FileWriter(outpath, false);
            fwriter.write(manifestXml);
            fwriter.flush();
            fwriter.close();
            return true;
        } catch (ParserException e) {
            System.out.println("no manifest!");
            return false;
        }
    }
}


