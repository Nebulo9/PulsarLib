package fr.nebulo9.pulsarlib.message.color;

/**
 * Lists in an enum the colors codes in chat, MOTD and JSON formats.
 * @author Nebulo9
 * @version 1.1
 */
public enum ColorCode {
    DARK_RED("§4","\\u00A74","dark_red"),
    RED("§c","\\u00A7c","red"),
    GOLD("§6","\\u00A76","gold"),
    YELLOW("§e","\\u00A7e","yellow"),
    DARK_GREEN("§2","\\u00A72","dark_green"),
    GREEN("§a","\\u00A7a","green"),
    AQUA("§b","\\u00A7b","aqua"),
    DARK_AQUA("§3","\\u00A73","dark_aqua"),
    DARK_BLUE("§1","\\u00A71","dark_blue"),
    BLUE("§9","\\u00A79","blue"),
    LIGHT_PURPLE("§d","\\u00A7d","light_purple"),
    DARK_PURPLE("§5","\\u00A75","dark_purple"),
    WHITE("§f","\\u00A7f","white"),
    GREY("§7","\\u00A77","gray"),
    DARK_GRAY("§8","\\u00A78","dark_gray"),
    BLACK("§0","\\u00A70","black"),

    RESET("§r","\\u00A7r",""),
    BOLD("§l","\\u00A7l","bold"),
    ITALIC("§o","\\u00A7o","italic"),
    UNDERLINE("§n","\\u00A7n","underlined"),
    STRIKE("§m","\\u00A7m","strikethrough"),
    MAGIC("§k","\\u00A7k","obfuscated");

    private String chatCode;
    private String motdCode;
    private String jsonCode;

    /**
     * Returns the chat format code.
     * @return the <a href="https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/String.html">String</a> code.
     */
    public String getChat() {
        return chatCode;
    }

    /**
     * Returns the MOTD format code.
     * @return the <a href="https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/String.html">String</a> code.
     */
    public String getMOTD() {
        return motdCode;
    }

    /**
     * Returns the JSON format code.
     * @return the <a href="https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/String.html">String</a> code.
     */
    public String getJSON() {
        return jsonCode;
    }

    ColorCode(String chatCode, String motdCode, String jsonCode) {
        this.chatCode = chatCode;
        this.motdCode = motdCode;
        this.jsonCode = jsonCode;
    }
}
