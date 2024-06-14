public class FlPref {
    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        String pref = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pref) != 0) {
                pref = pref.substring(0, pref.length() - 1);
            }
            if (pref.length() == 0) {
                break;
            }
        }
        System.out.println(pref);
    }
}
