package ru.sbt.mipt.oop;

public class DoorClosedAction implements Action {

    private final String doorId;

    public DoorClosedAction(SensorEvent event) {
        this.doorId = event.getObjectId();
    }

    @Override
    public void apply(Object obj) {
        if (obj instanceof Room room) {
            room.execute(element -> {
                if (element instanceof Door door) {
                    if (door.getId().equals(doorId)) {
                        door.setOpen(false);
                        System.out.println("Door " + doorId + " in room " + room.getName() + " was closed.");
                    }
                }
            });
        }
    }

}
