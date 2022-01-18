package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        Item created = tracker.findAll().get(0);
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
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[]
                {"0", String.valueOf(item.getId()), "New item name", "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditItem(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));

    }

    @Test
    public void whenDeleteItemNew() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItem(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in  = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(),
                is("Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditItem(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Item third = tracker.add(new Item("Third"));
        Input in = new StubInput(new String[] {"0", String.valueOf(second.getId()), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemId(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + second + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindItemsNameActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Item third = tracker.add(new Item("Third"));
        Input in = new StubInput(new String[] {"0", "Second", "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemsName(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                   "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + second + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenShowItemsActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Item third = tracker.add(new Item("Third"));
        Input in = new StubInput(new String[] {"0", "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowItems(out));
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
                + "=== Show all items ===" + ln
                + first + ln
                + second + ln
                + third + ln
                + "Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
                + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-1", "0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgram(out));
        new StartUI(out).init(in, tracker, actions);
        String  ln = System.lineSeparator();
        assertThat(out.toString(), is(
                   "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

}