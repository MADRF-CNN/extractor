import org.omg.CORBA.StringHolder;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class hexToImage {
    public static void main(String[] args) throws IOException {
        //注释的是rgb图像的测试步骤，此注释作为提醒
//        String path = "F:\\newOUT\\";
//        for (int i = 1; i < 2008; i++) {
//            File file = new File(path + i + ".txt");
//            if (!file.exists()) {
//                file.createNewFile();
//                System.out.println(i + "  makedir  success");
//            } else {
//                hexToImage test = new hexToImage();
//                String s = test.readFileContent(path + i + ".txt");
//                byte[] bytes = test.hexToByteArray(s);
//                if (bytes.length / 3000 == 0) {
//                    System.out.println("no height");
//                } else {
//                    test.rgbBytesToJpg(bytes, 1000, bytes.length / 3000, "F:\\newOUTPic\\" + i + ".jpg");
//                    System.out.println(i + "  complete");
//                }
//            }
//        }

        File file = new File("C:\\Users\\WeiHH\\Desktop\\1.txt");
        hexToImage test = new hexToImage();
        String s = test.readFileContent("C:\\Users\\WeiHH\\Desktop\\4.txt");
        int[] gray = new int[s.length()/2];
        for (int i = 0; i < gray.length; i = i+2) {
            gray[i] = Integer.parseInt(s.substring(i, i+2),16);
            test.grayBytesToJpg(gray[i], 500, gray.length/500, "C:\\Users\\WeiHH\\Desktop\\1.jpg");
        }

    }

    private int[] rgb24ToPixel(byte[] rgb24, int width, int height) {
        int[] pix = new int[rgb24.length / 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int idx = width * i + j;
                int rgbIdx = idx * 3;
                int red = rgb24[rgbIdx];
                int green = rgb24[rgbIdx + 1];
                int blue = rgb24[rgbIdx + 2];
                int color = (blue & 0x000000FF) | (green << 8 & 0x0000FF00) | (red << 16 & 0x00FF0000);
                pix[idx] = color;
            }
        }
        return pix;
    }

    public void rgbBytesToJpg(byte[] rgb, int width, int height, String path) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufferedImage.setRGB(0, 0, width, height, rgb24ToPixel(rgb, width, height), 0, width);
        File file = new File(path);
        ImageIO.write(bufferedImage, "jpg", file);
    }

    public void grayBytesToJpg(int gray, int width, int height, String path) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int newPixel = colorToRGB(255, gray, gray, gray);
                bufferedImage.setRGB(i,j,newPixel);
            }
        }
        File file = new File(path);
        ImageIO.write(bufferedImage, "jpg", file);
    }

    public byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }

    public byte[] hexToByteArray(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            //奇数
            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;
        } else {
            //偶数
            result = new byte[(hexlen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }
        return result;
    }

    public String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    private static int colorToRGB(int alpha, int red, int green, int blue) {

        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;

    }
}
