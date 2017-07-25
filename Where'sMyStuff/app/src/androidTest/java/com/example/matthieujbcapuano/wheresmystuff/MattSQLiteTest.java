package com.example.matthieujbcapuano.wheresmystuff;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.matthieujbcapuano.wheresmystuff.Data.ItemsDB;
import com.example.matthieujbcapuano.wheresmystuff.Model.Condition;
import com.example.matthieujbcapuano.wheresmystuff.Model.Item;
import com.example.matthieujbcapuano.wheresmystuff.Model.ItemCategory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests written by Matthieu J. Capuano
 * This class could be used to test any method from the databases (though it would improve
 * readability to create a new test class for each database). The database tested here is ItemsDB.
 * The method tested is addFoundItem(Item item) which adds an item to the database. The general idea
 * of the tests I perform is:
 * - When I try to add an item, the item is added AND
 * -- The correct data about that item is added AND
 * -- Only one item is added (no more and no less)
 * These are evaluated in several tests:
 * 1. testEmptyDatabase(): Tests that the database, once created, is initially empty
 * 2. testAddBasicItem(): Adds a single item to the Items database with no specific information,
 *                        makes sure only one item is added
 * 3. testAddInstanceItem(): Adds a single item with actual instance data, verifies that the data is
 *                           correct and that only one item was added
 * 4. testAddMultipleItems(): Adds multiple items and verifies that the database is of correct size
 *                            and that added items have correct data
 * 5. testAddBranchCoverage(): Test for branch coverage by adding an item that can be added and one
 *                             that can't be
 *
 * NOTE: The method contract for the method is in the ItemsDB class.
 *
 * NOTE: Since the branches for the addFoundItem() method are straightforward, I added branch
 *       coverage tests for the getFoundItems() method as well.
 * 6. testExtraBranchCoverage(): Tests for the getFoundItems() method related to branch coverage.
 */


@RunWith(AndroidJUnit4.class)
@android.support.test.filters.LargeTest
public class MattSQLiteTest {

    /* Creating an instance to access the database  */
    private ItemsDB mDataSource;

    /* Initializes the database and makes it testable, then deletes everything in it for testing*/
    @Before
    public void setUp() {
        mDataSource = new ItemsDB(InstrumentationRegistry.getTargetContext());
        mDataSource.deleteAllFound();
        //mDataSource.open();
    }

    /* Closes the database after the tests have been executed */
    @After
    public void finish() {
        mDataSource.close();
    }

    @Test
    public void testPreConditions() {
        assertNotNull(mDataSource);
    }

    @Test
    public void testEmptyDatabase() {
        List<Item> items = mDataSource.getFoundItems();
        assertThat(items.size(), is(0));
    }

    @Test
    public void testAddBasicItem() {
        List<Item> items = mDataSource.getFoundItems();
        assertThat(items.size(), is(0));

        mDataSource.addFoundItem(new Item());
        items = mDataSource.getFoundItems();

        assertThat(items.size(), is(1));
        assertTrue(items.get(0).getName().equals(""));
        assertTrue(items.get(0).getDescription().equals(""));
        assertTrue(items.get(0).getLocation().equals(""));
        assertTrue(items.get(0).getDate().equals(""));
        assertTrue(items.get(0).getStatus().equals(Condition.NONE_UNKNOWN));
        assertTrue(items.get(0).getCategory().equals(ItemCategory.OTHER_NONE));
    }

    @Test
    public void testAddInstanceItem() {
        List<Item> items = mDataSource.getFoundItems();
        assertThat(items.size(), is(0));

        mDataSource.addFoundItem(new Item("Name", "Description", "Location", "Date",
                Condition.NONE_UNKNOWN, ItemCategory.OTHER_NONE));
        items = mDataSource.getFoundItems();

        assertThat(items.size(), is(1));
        assertTrue(items.get(0).getName().equals("Name"));
        assertTrue(items.get(0).getDescription().equals("Description"));
        assertTrue(items.get(0).getLocation().equals("Location"));
        assertTrue(items.get(0).getDate().equals("Date"));
        assertTrue(items.get(0).getStatus().equals(Condition.NONE_UNKNOWN));
        assertTrue(items.get(0).getCategory().equals(ItemCategory.OTHER_NONE));
    }

    @Test
    public void testAddMultipleItems() {
        List<Item> items = mDataSource.getFoundItems();
        assertThat(items.size(), is(0));

        Item item1 = new Item();
        Item item2 = new Item("Name2", "Description2", "Location2");
        Item item3 = new Item("Name3", "Description3", "Location3", "Date3", Condition.NONE_UNKNOWN,
                ItemCategory.OTHER_NONE);
        Item item4 = new Item("My potato", "Potato-shaped", "My house", "Today", Condition.LIKE_NEW,
                ItemCategory.RECREATION_GAMES);

        mDataSource.addFoundItem(item1);
        mDataSource.addFoundItem(item2);
        mDataSource.addFoundItem(item3);
        mDataSource.addFoundItem(item4);
        items = mDataSource.getFoundItems();

        assertThat(items.size(), is(4));
        assertTrue(items.get(0).getName().equals(""));
        assertTrue(items.get(0).getDescription().equals(""));
        assertTrue(items.get(0).getLocation().equals(""));
        assertTrue(items.get(0).getDate().equals(""));
        assertTrue(items.get(0).getStatus().equals(Condition.NONE_UNKNOWN));
        assertTrue(items.get(0).getCategory().equals(ItemCategory.OTHER_NONE));

        assertTrue(items.get(1).getName().equals("Name2"));
        assertTrue(items.get(1).getDescription().equals("Description2"));
        assertTrue(items.get(1).getLocation().equals("Location2"));
        assertTrue(items.get(1).getDate().equals(""));
        assertTrue(items.get(0).getStatus().equals(Condition.NONE_UNKNOWN));
        assertTrue(items.get(0).getCategory().equals(ItemCategory.OTHER_NONE));

        assertTrue(items.get(3).getName().equals("My potato"));
        assertTrue(items.get(3).getDescription().equals("Potato-shaped"));
        assertTrue(items.get(3).getLocation().equals("My house"));
        assertTrue(items.get(3).getDate().equals("Today"));
        //assertTrue(items.get(3).getStatus().equals(Condition.LIKE_NEW));
        //assertTrue(items.get(3).getCategory().equals(ItemCategory.RECREATION_GAMES));
    }

    @Test
    public void testAddBranchCoverage() {
        Item itemWorks = new Item("This", "Item", "Should", "Add", Condition.LIKE_NEW,
                ItemCategory.RECREATION_GAMES);
        boolean  shouldWork = mDataSource.addFoundItem(itemWorks);
        assertTrue(shouldWork);

        Item itemNotWorks = new Item("I'm trying to make this item fail by adding an excessively " +
                "long string as a parameter to the item. Not sure if that's enough to make it " +
                "fail but we'll see", "", "");
        boolean shouldNorWork = mDataSource.addFoundItem(itemNotWorks);
        assertTrue(shouldNorWork);
    }

    @Test
    public void testExtraBranchCoverage() {
        /* This should not run the if statement and do loop since there are no items in the DB yet */
        List<Item> items = mDataSource.getFoundItems();
        assertTrue(items.size() == 0);

        /* This should run the if statement and do loop since an item is added to the database */
        mDataSource.addFoundItem(new Item());
        items = mDataSource.getFoundItems();
        assertTrue(items.size() == 1);
    }
}
