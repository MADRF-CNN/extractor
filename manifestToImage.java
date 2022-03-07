import java.io.File;
import java.io.IOException;

public class manifestToImage {
    public static void main(String[] args) throws IOException {
        String picPath = "D:\\dataset\\malManifestTXT";
        File file1 = new File(picPath);
        File[] filePathLists1 = file1.listFiles();
        System.out.println(filePathLists1.length);
        for (int i = 1; i < filePathLists1.length+1; i++) {
            File test = new File("D:\\dataset\\malManifestTXT\\"+i+".txt");
            if(!test.exists()){
                System.out.println("没有文件");
            } else if (test.length() == 0){
                System.out.println(i + "  no txt Color.");
            } else {
                hexToImage h = new hexToImage();
                String s = h.readFileContent(picPath+"\\"+i+".txt");
                byte[] bytes = h.hexToByteArray(s);
                if (bytes.length / 600 <= 0){
                    System.out.println("data is small, can be ignored");
                } else {
                    h.rgbBytesToJpg(bytes, 200, bytes.length / 600, "D:\\dataset\\malManifestPic\\"+i+".jpg");
                }
            }
        }
    }

}
