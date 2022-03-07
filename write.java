import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class write {
    public static void main(String[] args) throws IOException {
        write w = new write();
//        String path = "D:\\dataset\\LegManifest\\";
//        String outpath = "D:\\dataset\\HexLegManifest\\";
        String path = "G:\\119\\leg_manifest\\";
        String outpath = "G:\\119\\leg_manifest_hex\\";

        for (int i = 1; i < 2008; i++) {
            String s = w.readFile(path + i + ".txt");
            w.writeFile(outpath + i + ".txt", s, 0, s.length() / 2);
        }


    }

    public void mergeFiles(int threadNum, String[] inpath, String outpath) throws IOException {
        if (threadNum == 1) {
            HashMap<String, Integer> hashMap1 = getInfo(inpath[0]);
            String result1 = readFile(inpath[0]);
            writeFile(outpath, result1, hashMap1.get("stringIdOff"), hashMap1.get("stringIdSize"));
            writeFile(outpath, result1, hashMap1.get("typeIdOff"), hashMap1.get("typeIdSize"));
            writeFile(outpath, result1, hashMap1.get("protoIdOff"), hashMap1.get("protoIdSize"));
            writeFile(outpath, result1, hashMap1.get("fieldIdOff"), hashMap1.get("fieldIdSize"));
            writeFile(outpath, result1, hashMap1.get("methodIdOff"), hashMap1.get("methodIdSize"));
            writeFile(outpath, result1, hashMap1.get("classIdOff"), hashMap1.get("classIdSize"));
            writeFile(outpath, result1, 0, result1.length() / 10);
        } else if (threadNum == 2) {
            HashMap<String, Integer> hashMap1 = getInfo(inpath[0]);
            HashMap<String, Integer> hashMap2 = getInfo(inpath[1]);
            String result1 = readFile(inpath[0]);
            String result2 = readFile(inpath[1]);
            writeFile(outpath, result1, hashMap1.get("stringIdOff"), hashMap1.get("stringIdSize"));
            writeFile(outpath, result2, hashMap2.get("stringIdOff"), hashMap2.get("stringIdSize"));
            writeFile(outpath, result1, hashMap1.get("typeIdOff"), hashMap1.get("typeIdSize"));
            writeFile(outpath, result2, hashMap2.get("typeIdOff"), hashMap2.get("typeIdSize"));
            writeFile(outpath, result1, hashMap1.get("protoIdOff"), hashMap1.get("protoIdSize"));
            writeFile(outpath, result2, hashMap2.get("protoIdOff"), hashMap2.get("protoIdSize"));
            writeFile(outpath, result1, hashMap1.get("fieldIdOff"), hashMap1.get("fieldIdSize"));
            writeFile(outpath, result2, hashMap2.get("fieldIdOff"), hashMap2.get("fieldIdSize"));
            writeFile(outpath, result1, hashMap1.get("methodIdOff"), hashMap1.get("methodIdSize"));
            writeFile(outpath, result2, hashMap2.get("methodIdOff"), hashMap2.get("methodIdSize"));
            writeFile(outpath, result1, hashMap1.get("classIdOff"), hashMap1.get("classIdSize"));
            writeFile(outpath, result2, hashMap2.get("classIdOff"), hashMap2.get("classIdSize"));
        } else if (threadNum == 3) {
            HashMap<String, Integer> hashMap1 = getInfo(inpath[0]);
            HashMap<String, Integer> hashMap2 = getInfo(inpath[1]);
            HashMap<String, Integer> hashMap3 = getInfo(inpath[2]);
            String result1 = readFile(inpath[0]);
            String result2 = readFile(inpath[1]);
            String result3 = readFile(inpath[2]);
            writeFile(outpath, result1, hashMap1.get("stringIdOff"), hashMap1.get("stringIdSize"));
            writeFile(outpath, result2, hashMap2.get("stringIdOff"), hashMap2.get("stringIdSize"));
            writeFile(outpath, result3, hashMap3.get("stringIdOff"), hashMap3.get("stringIdSize"));
            writeFile(outpath, result1, hashMap1.get("typeIdOff"), hashMap1.get("typeIdSize"));
            writeFile(outpath, result2, hashMap2.get("typeIdOff"), hashMap2.get("typeIdSize"));
            writeFile(outpath, result3, hashMap3.get("typeIdOff"), hashMap3.get("typeIdSize"));
            writeFile(outpath, result1, hashMap1.get("protoIdOff"), hashMap1.get("protoIdSize"));
            writeFile(outpath, result2, hashMap2.get("protoIdOff"), hashMap2.get("protoIdSize"));
            writeFile(outpath, result3, hashMap3.get("protoIdOff"), hashMap3.get("protoIdSize"));
            writeFile(outpath, result1, hashMap1.get("fieldIdOff"), hashMap1.get("fieldIdSize"));
            writeFile(outpath, result2, hashMap2.get("fieldIdOff"), hashMap2.get("fieldIdSize"));
            writeFile(outpath, result3, hashMap3.get("fieldIdOff"), hashMap3.get("fieldIdSize"));
            writeFile(outpath, result1, hashMap1.get("methodIdOff"), hashMap1.get("methodIdSize"));
            writeFile(outpath, result2, hashMap2.get("methodIdOff"), hashMap2.get("methodIdSize"));
            writeFile(outpath, result3, hashMap3.get("methodIdOff"), hashMap3.get("methodIdSize"));
            writeFile(outpath, result1, hashMap1.get("classIdOff"), hashMap1.get("classIdSize"));
            writeFile(outpath, result2, hashMap2.get("classIdOff"), hashMap2.get("classIdSize"));
            writeFile(outpath, result3, hashMap3.get("classIdOff"), hashMap3.get("classIdSize"));
        } else if (threadNum == 4) {
            HashMap<String, Integer> hashMap1 = getInfo(inpath[0]);
            HashMap<String, Integer> hashMap2 = getInfo(inpath[1]);
            HashMap<String, Integer> hashMap3 = getInfo(inpath[2]);
            HashMap<String, Integer> hashMap4 = getInfo(inpath[3]);
            String result1 = readFile(inpath[0]);
            String result2 = readFile(inpath[1]);
            String result3 = readFile(inpath[2]);
            String result4 = readFile(inpath[3]);
            writeFile(outpath, result1, hashMap1.get("stringIdOff"), hashMap1.get("stringIdSize"));
            writeFile(outpath, result2, hashMap2.get("stringIdOff"), hashMap2.get("stringIdSize"));
            writeFile(outpath, result3, hashMap3.get("stringIdOff"), hashMap3.get("stringIdSize"));
            writeFile(outpath, result4, hashMap4.get("stringIdOff"), hashMap4.get("stringIdSize"));
            writeFile(outpath, result1, hashMap1.get("typeIdOff"), hashMap1.get("typeIdSize"));
            writeFile(outpath, result2, hashMap2.get("typeIdOff"), hashMap2.get("typeIdSize"));
            writeFile(outpath, result3, hashMap3.get("typeIdOff"), hashMap3.get("typeIdSize"));
            writeFile(outpath, result4, hashMap4.get("typeIdOff"), hashMap4.get("typeIdSize"));
            writeFile(outpath, result1, hashMap1.get("protoIdOff"), hashMap1.get("protoIdSize"));
            writeFile(outpath, result2, hashMap2.get("protoIdOff"), hashMap2.get("protoIdSize"));
            writeFile(outpath, result3, hashMap3.get("protoIdOff"), hashMap3.get("protoIdSize"));
            writeFile(outpath, result4, hashMap4.get("protoIdOff"), hashMap4.get("protoIdSize"));
            writeFile(outpath, result1, hashMap1.get("fieldIdOff"), hashMap1.get("fieldIdSize"));
            writeFile(outpath, result2, hashMap2.get("fieldIdOff"), hashMap2.get("fieldIdSize"));
            writeFile(outpath, result3, hashMap3.get("fieldIdOff"), hashMap3.get("fieldIdSize"));
            writeFile(outpath, result4, hashMap4.get("fieldIdOff"), hashMap4.get("fieldIdSize"));
            writeFile(outpath, result1, hashMap1.get("methodIdOff"), hashMap1.get("methodIdSize"));
            writeFile(outpath, result2, hashMap2.get("methodIdOff"), hashMap2.get("methodIdSize"));
            writeFile(outpath, result3, hashMap3.get("methodIdOff"), hashMap3.get("methodIdSize"));
            writeFile(outpath, result4, hashMap4.get("methodIdOff"), hashMap4.get("methodIdSize"));
            writeFile(outpath, result1, hashMap1.get("classIdOff"), hashMap1.get("classIdSize"));
            writeFile(outpath, result2, hashMap2.get("classIdOff"), hashMap2.get("classIdSize"));
            writeFile(outpath, result3, hashMap3.get("classIdOff"), hashMap3.get("classIdSize"));
            writeFile(outpath, result4, hashMap4.get("classIdOff"), hashMap4.get("classIdSize"));
        }
    }

    public String readFile(String inpath) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(inpath));

        String result = "";
        byte[] b = new byte[20000];
        while (in.read(b) != -1 && result.length() < 4000000) {
            result += DatatypeConverter.printHexBinary(b);
        }
        return result;

    }

    public void writeFile(String out, String str, int offset, int size) throws IOException {
        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(out, true));
        BufferedWriter writer = new BufferedWriter(write);
        writer.write(str.substring(offset * 2, size * 2 + offset * 2));
        writer.flush();
        write.close();
        writer.close();

    }

    public HashMap<String, Integer> getInfo(String path) throws IOException {
        HashMap<String, Integer> info = new HashMap<>();
        DataInputStream in = new DataInputStream(new FileInputStream(path));

        ArrayList<String> result = new ArrayList<>();
        byte[] b = new byte[1];
        while (in.read(b) != -1 && result.size() < 112) {
            result.add(DatatypeConverter.printHexBinary(b));
        }

        info.put("stringIdSize", HexToInt(new ArrayList(result.subList(56, 60))));
        info.put("stringIdOff", HexToInt(new ArrayList(result.subList(60, 64))));
        info.put("typeIdSize", HexToInt(new ArrayList(result.subList(64, 68))));
        info.put("typeIdOff", HexToInt(new ArrayList(result.subList(68, 72))));
        info.put("protoIdSize", HexToInt(new ArrayList(result.subList(72, 76))));
        info.put("protoIdOff", HexToInt(new ArrayList(result.subList(76, 80))));
        info.put("fieldIdSize", HexToInt(new ArrayList(result.subList(80, 84))));
        info.put("fieldIdOff", HexToInt(new ArrayList(result.subList(84, 88))));
        info.put("methodIdSize", HexToInt(new ArrayList(result.subList(88, 92))));
        info.put("methodIdOff", HexToInt(new ArrayList(result.subList(92, 96))));
        info.put("classIdSize", HexToInt(new ArrayList(result.subList(96, 100))));
        info.put("classIdOff", HexToInt(new ArrayList(result.subList(100, 104))));

        in.close();

        return info;
    }

    public static int HexToInt(ArrayList<String> arrayList) {
        Collections.reverse(arrayList);
        String a = "";
        for (int i = 0; i < arrayList.size(); i++) {
            a += arrayList.get(i);
        }
        return Integer.parseInt(a, 16);
    }

}
