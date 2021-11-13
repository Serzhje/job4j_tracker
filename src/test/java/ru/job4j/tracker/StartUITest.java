package ru.job4j.tracker;

import org.junit.Test;
import java.util.Scanner;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answer = {"Fix PC"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        UserAction action = new CreateAction();
        action.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("New Item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), "edited item"
        };
        UserAction action = new EditItem();
        action.execute(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName(), is("edited item"));
    }

    @Test
    public void whenDeleteItemOld() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        Item third = new Item("Third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        String[] answer = {String.valueOf(second.getId())};
        UserAction action = new DeleteItem();
        action.execute(new StubInput(answer), tracker);
        Item itemDelete = tracker.findById(second.getId());
        assertNull(itemDelete);
    }

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ExitProgram()};
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[] {"0", "1", "New item name", "1"});
        UserAction[] actions = {new EditItem(), new ExitProgram()};
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));

    }

    @Test
    public void whenDeleteItemNew() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new DeleteItem(), new ExitProgram()};
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}