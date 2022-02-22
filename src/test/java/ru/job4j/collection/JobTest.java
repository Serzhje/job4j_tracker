package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenAscByName() {
        Comparator<Job> cmpNameAsc = new JobAscByName();
        int rsl = cmpNameAsc.compare(
                new Job("Impl task", 1),
                new Job("Tets task", 0)
        );

        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscByPriority() {
        Comparator<Job> cmpPriorityAsc = new JobAscByPriority();
        int rsl = cmpPriorityAsc.compare(
          new Job("Tets task", 0),
          new Job("Impl task", 1)
        );

        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> cmpNameDesc = new JobDescByName();
        int rsl = cmpNameDesc.compare(
                new Job("Fix bug", 2),
                new Job("Tets task", 1)
        );

        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenDescByPriorty() {
        Comparator<Job> cmpPriorityDesc = new JobDescByPriority();
        int rsl = cmpPriorityDesc.compare(
                new Job("Tets task", 0),
                new Job("Fix bug", 1)
        );

        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparByNameAndPriorityAsc() {
        Comparator<Job> cmpNamePriorityAsc = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriorityAsc.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByPriorityAndNameAsc() {
        Comparator<Job> cmpPriorityNameAsc = new JobAscByPriority()
                .thenComparing(new JobAscByName());
        int rsl = cmpPriorityNameAsc.compare(
                new Job("Fix bug", 3),
                new Job("Impl task", 3)
        );

        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparByNameAndPriorityDesc() {
        Comparator<Job> cmpNamePriorityDesc = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriorityDesc.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparByPriorityAndNameDesc() {
        Comparator<Job> cmpPriorityNameDesc = new JobDescByPriority()
                .thenComparing(new JobDescByName());
        int rsl = cmpPriorityNameDesc.compare(
                new Job("Impl task", 4),
                new Job("Test task", 4)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparByPriorityAndNameEqual() {
        Comparator<Job> cmpPriorityNameDesc = new JobDescByPriority()
                .thenComparing(new JobDescByName());
        int rsl = cmpPriorityNameDesc.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 0)
        );
        assertThat(rsl, equalTo(0));
    }
}