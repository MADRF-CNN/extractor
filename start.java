import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class start {
    public static void main(String[] args) throws IOException {
//        getFiles("C:\\Users\\WeiHH\\Desktop\\OUT\\1");
        String path = "G:\\119\\leg";
        File file = new File(path);
        File[] filePathLists = file.listFiles();

        for (int i = 1; i < filePathLists.length+1; i++) {
            String[] names = getFiles(path+"\\"+i);
            if (names.length == 0){
                File file1 = new File("G:\\119\\leg_txt\\"+i+".txt");
                file1.createNewFile();
                System.out.println(i + "  no dex files");
            } else if (names.length == 1){
//                dexToImage d = new dexToImage();
//                ArrayList hexArray = d.getHexFromDex(names[0]);
//                int[] redResults = d.getRedFromDifferentPart(hexArray);
//                int[] blueResult = d.getBlueFromDifferentPart(hexArray);
//                d.addColor(112, 0, redResults, blueResult, hexArray, "C:\\Users\\WeiHH\\Desktop\\txtColor\\"+i+".txt", 0);
//                d.addColor(d.getSizeAndOffset(hexArray, 56)[0], 1, redResults, blueResult, hexArray, "C:\\Users\\WeiHH\\Desktop\\txtColor\\"+i+".txt", d.getSizeAndOffset(hexArray, 56)[1]);
//                d.addColor(d.getSizeAndOffset(hexArray, 64)[0], 2, redResults, blueResult, hexArray, "C:\\Users\\WeiHH\\Desktop\\txtColor\\"+i+".txt", d.getSizeAndOffset(hexArray, 64)[1]);
//                d.addColor(d.getSizeAndOffset(hexArray, 72)[0], 3, redResults, blueResult, hexArray, "C:\\Users\\WeiHH\\Desktop\\txtColor\\"+i+".txt", d.getSizeAndOffset(hexArray, 72)[1]);
//                d.addColor(d.getSizeAndOffset(hexArray, 80)[0], 4, redResults, blueResult, hexArray, "C:\\Users\\WeiHH\\Desktop\\txtColor\\"+i+".txt", d.getSizeAndOffset(hexArray, 80)[1]);
//                d.addColor(d.getSizeAndOffset(hexArray, 88)[0], 5, redResults, blueResult, hexArray, "C:\\Users\\WeiHH\\Desktop\\txtColor\\"+i+".txt", d.getSizeAndOffset(hexArray, 88)[1]);
//                d.addColor(d.getSizeAndOffset(hexArray, 96)[0], 6, redResults, blueResult, hexArray, "C:\\Users\\WeiHH\\Desktop\\txtColor\\"+i+".txt", d.getSizeAndOffset(hexArray, 96)[1]);
//                System.out.println(i+"  complete");
                write wr = new write();
                String out = "G:\\119\\leg_txt\\"+i+".txt";
                wr.mergeFiles(names.length, names,out);
                System.out.println(i+"  complete");
            } else {
                write w = new write();
                String out = "G:\\119\\leg_txt\\"+i+".txt";
                w.mergeFiles(names.length, names,out);
                System.out.println(i+"  complete");
            }
        }

        String picPath = "G:\\119\\leg_txt";
        File file1 = new File(picPath);
        File[] filePathLists1 = file1.listFiles();
        System.out.println(filePathLists1.length);
        for (int i = 1; i < filePathLists1.length+1; i++) {
            File test = new File("G:\\119\\leg_txt\\"+i+".txt");
            if (test.length() == 0){
                System.out.println(i + "  no txt Color.");
            } else {
                hexToImage h = new hexToImage();
                String s = h.readFileContent(picPath+"\\"+i+".txt");
                byte[] bytes = h.hexToByteArray(s);
                if (bytes.length / 900 <= 0){
                    System.out.println("data is small, can be ignored");
                } else {
                    h.rgbBytesToJpg(bytes, 200, bytes.length / 900, "G:\\119\\leg_pic\\Leg."+i+".jpg");
                }
            }

        }


    }

    public static String[] getFiles(String filepath){
        File file = new File(filepath);

        File[] filePathLists = file.listFiles();
        String[] path = new String[filePathLists.length];

        for (int i = 0; i < filePathLists.length; i ++) {
            path[i] = filePathLists[i].getAbsolutePath();
        }

        return path;
    }


}
