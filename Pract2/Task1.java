package Pract2;

public class Task1 {
    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        } else {
            QUERY = args[0];
            PARAMS = args[1];
        }

        Answer ans = new Answer();
        System.out.println(ans.answer(QUERY, PARAMS));
    }

    public static class Answer {
        public static String answer(String QUERY, String PARAMS) {
            // Напишите свое решение ниже
            StringBuilder sb = new StringBuilder(QUERY);
            PARAMS = PARAMS.replace("{", "").replace("}", "").replace('"', ' ');
            String[] filters = PARAMS.split(",");
            for (int i = 0; i < filters.length; i++) {
                String[] fil = filters[i].split(":");
                System.out.printf("%s %s\n", fil[0].trim(), fil[1].trim());
                if (!fil[1].trim().equals("null")) {
                    if (i > 0) {
                        sb.append(" and ");
                    }
                    sb.append(fil[0].trim()).append("=").append("'" + fil[1].trim() + "'");
                }
            }
            return sb.toString();
        }
    }
}
