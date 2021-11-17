package ru.job4j.tracker;

import org.junit.Test;
import java.util.Scanner;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        String[] answer = {"Fix PC"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        UserAction action = new CreateAction(out);
        action.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("New Item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), "edited item"
        };
        UserAction action = new EditItem(out);
        action.execute(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName(), is("edited item"));
    }

    @Test
    public void whenDeleteItemOld() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        Item third = new Item("Third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        String[] answer = {String.valueOf(second.getId())};
        UserAction action = new DeleteItem(out);
        action.execute(new StubInput(answer), tracker);
        Item itemDelete = tracker.findById(second.getId());
        assertNull(itemDelete);
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(out), new ExitProgram(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[]
                {"0", String.valueOf(item.getId()), "New item name", "1"});
        UserAction[] actions = {new EditItem(out), new ExitProgram(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));

    }

    @Test
    public void whenDeleteItemNew() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new DeleteItem(out), new ExitProgram(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in  = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitProgram(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(),
                is("Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()));
    }
}