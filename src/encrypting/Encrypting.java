package encrypting;

/**
 *
 * @author Maximilian
 */
public class Encrypting {

    /**
     * @param args the command line arguments
     */
    char[] Alphabeth = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
        'X', 'Y', 'Z'};
    char[][] VigenereQuadrat;

    public static void main(String[] args) {
        Encrypting sys = new Encrypting();
        sys.los();

    }

    void los() {

        fillVigenere();
        crypt("HELLO WORLD", "HELLO  JAVA");
    }

    void fillVigenere() {
        VigenereQuadrat = new char[Alphabeth.length][Alphabeth.length];

        for (int y = 0; y < Alphabeth.length; y++) {
            for (int i = 0; i < Alphabeth.length; i++) {
                if (i + y < Alphabeth.length) {
                    VigenereQuadrat[y][i] = (char) Alphabeth[i + y];
                } else {
                    VigenereQuadrat[y][i] = (char) Alphabeth[i + y - Alphabeth.length];
                }
            }
        }
    }

    void showVigenere() {
        for (int i = 0; i < VigenereQuadrat.length; i++) {
            for (int y = 0; y < VigenereQuadrat.length; y++) {
                System.out.print(VigenereQuadrat[i][y] + " ");
            }
            System.out.print('\n');
        }
    }

    String crypt(String Input, String Key) {
        String hashedString = "";

        String cryptKey = Key;
        while (cryptKey.length() < Input.length()) {
            cryptKey = cryptKey + Key;

        }

        int charHorizontalPosition = 0;
        int charVerticalPosition = 0;


        int cryptPosition = 0;
        while (cryptPosition < Input.length()) {

            int tmp = 0;
            while (tmp < VigenereQuadrat.length) {
                if (VigenereQuadrat[tmp][0] == Input.charAt(cryptPosition)) {
                    charHorizontalPosition = tmp;
                }
                tmp++;
            }


            tmp = 0;

            while (tmp < VigenereQuadrat.length) {

                if (VigenereQuadrat[0][tmp] == cryptKey.charAt(cryptPosition)) {
                    charVerticalPosition = tmp;
                }
                tmp++;
            }


            hashedString = hashedString + VigenereQuadrat[charHorizontalPosition][charVerticalPosition];

            cryptPosition++;
        }
        System.out.println(hashedString);
        return hashedString;
    }
}
