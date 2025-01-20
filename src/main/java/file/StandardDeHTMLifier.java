package file;

public class StandardDeHTMLifier implements DeHTMLifier {
    @Override
    public String deHTMLify(String text) {
        return text.replace("<", "&lt;").replace(">", "&gt;").replace("/sc", ";");
    }
}
