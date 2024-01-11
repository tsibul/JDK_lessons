package hw5;

import java.util.HashMap;
import java.util.Map;

public class PhilLang {
    private final Map<String, String> MsgEng = new HashMap<>() {{
        put("thinkStart", "It's time to think");
        put("thinkFinish", "This new theory could be interesting");
        put("lookForFood", "Is there something to eat?");
        put("eatStart", "Oh! Let's start eating.");
        put("eatFinish", "Was very nice food. Thanks");
        put("stop", "Today's plan fulfilled. It's time to finish");
    }};

    private final Map<String, String> MsgRus = new HashMap<>() {{
        put("thinkStart", "Жрать нечем, надо чем-то убить время");
        put("thinkFinish", "Что за фигню я придумал?");
        put("lookForFood", "Ироды! Вилки есть?");
        put("eatStart", "Жрачка!!!");
        put("eatFinish", "(Рыгает) Так себе хавчик");
        put("stop", "Чото я объелся, пора баиньки");
    }};

    private final Map<String, String> MsgEll = new HashMap<>() {{
        put("thinkStart", "Ήρθε η ώρα να σκεφτούμε");
        put("thinkFinish", "Αυτή η νέα θεωρία μπορεί να έχει ενδιαφέρον");
        put("lookForFood", "Υπάρχει κάτι να φάμε?");
        put("eatStart", "Ας αρχίσουμε να τρώμε");
        put("eatFinish", "ήταν πολύ καλό φαγητό");
        put("stop", "Το σημερινό σχέδιο εκπληρώθηκε. Ήρθε η ώρα να τελειώσουμε");
    }};

    private String nationality;
    private HashMap<String, String> message;

    public PhilLang(String nationality) {
        this.nationality = nationality;
        if(nationality.equals("rus")){
            this.message = (HashMap<String, String>) MsgRus;
        } else if (nationality.equals("eng")){
            this.message = (HashMap<String, String>) MsgEng;
        } else {
            this.message = (HashMap<String, String>) MsgEll;
        }
    }

    public String getMessage(String ansCase) {
        return message.get(ansCase);
    }
}
