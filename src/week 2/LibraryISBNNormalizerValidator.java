public class LibraryISBNNormalizerValidator {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        String publisher = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return publisher + rest;
    }

    public static String validateAndFormat(String code) {
        String normalized = normalizeCode(code);

        if (normalized.length() != 13) {
            return "Invalid: wrong length";
        }

        String pubCode = normalized.substring(0, 3);
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(pubCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = normalized.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: body must be 10 digits";
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(" pen2026004251 "));
        System.out.println(validateAndFormat("12N2026004251"));
    }
}