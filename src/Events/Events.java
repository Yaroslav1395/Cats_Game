package Events;

import Cats.Cat;

public enum Events {
    POISONING(1, new Poisoning()),
    TRAUMA(2, new Trauma());

    private final int eventId;
    private final Eventable event;

    Events(int eventId, Eventable event) {
        this.eventId = eventId;
        this.event = event;
    }

    public int getEventId() {
        return eventId;
    }

    public static void eventRealize(int value, Cat cat){
        try {
            for (Events event: Events.values()) {
                if(event.getEventId() == value){
                    event.event.realizeEvent(cat);
                    break;
                }
            }
        }catch (RuntimeException e){
            System.out.println("Такого события нет. Попробуйте снова");
            eventRealize(value, cat);
        }
    }
}
