package ru.sbt.mipt.oop.actions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;

public record TurnOnLightAction(String lightId) implements Action {
    @Override
    public void apply(Object obj) {
        if (obj instanceof Room room) {
            room.execute(element -> {
                if (element instanceof Light light) {
                    if (light.getId().equals(lightId)) {
                        light.setOn(true);
                        System.out.println("Light " + lightId + " in room " + room.getName() + " was turned on.");
                    }
                }
            });
        }
    }
}
