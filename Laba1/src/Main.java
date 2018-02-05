import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws IOException {
            char[] alfavit = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
            char[] cipher=new char[33];
            for(int i=0;i<33;i++) {
                cipher[i]='9';
            }
            int j;
            for(char i:alfavit){
                do {
                    Random rand = new Random();
                    j = rand.nextInt(33);
                    if (cipher[j]=='9'){
                        cipher[j]=i;
                    }
                }while (i!=cipher[j]);
            }
            String text;
            Scanner in = new Scanner(System.in);
            text= in.nextLine();
            text=text.toLowerCase();
            int size = text.length();
            char[] rezult = new char[size];
            char [] input = text.toCharArray();
            for(int i=0;i<size;i++){
                if(input[i]==(char) 32){
                    rezult[i]=input[i];
                    continue;
                }
                for(j=0;j<alfavit.length;j++){
                    if (input[i]==alfavit[j]){
                        rezult[i]=cipher[j];
                    }
                }
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("C:/Users/ilya9/IdeaProjects/encryption/text.txt"), "UTF8"));
            for(int i=0;i<alfavit.length;i++){
                bw.write(alfavit[i]);
                bw.write(':');
                bw.write(cipher[i]);
                bw.write(", ");
            }
            bw.newLine();
            for(int i=0;i<size;i++){
                bw.write(rezult[i]);
                System.out.print(rezult[i]);
            }
            bw.flush();
            bw.close();
        }
}
