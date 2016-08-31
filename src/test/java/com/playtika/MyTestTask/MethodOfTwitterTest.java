package com.playtika.MyTestTask;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MethodOfTwitterTest {

    private MethodOfTwitter methodOfTwitter;

    @Before
    public void setUp() throws Exception {
        methodOfTwitter = new MethodOfTwitter();
    }

    @Test
      public void testGetUserTimeLine() throws Exception {
        Assert.assertNotNull(methodOfTwitter.getUserTimeLine());
    }

    @Test
    public void testGetSendDirectMessage() throws Exception {
        Assert.assertEquals(true, methodOfTwitter.getSendDirectMessage(124124, "Hello"));
    }

    @Test
    public void testGetDirectMessage() throws Exception {
        Assert.assertNotNull(methodOfTwitter.getDirectMessage());
    }

    @Test
    public void testGetMyStatusUpdate() throws Exception {
        Assert.assertEquals(true, methodOfTwitter.getMyStatusUpdate("LIFE IS GOOD!)"));
    }

    @Test
    public void testGetMyUpdateProfile() throws Exception {
        Assert.assertEquals(false, methodOfTwitter.getMyUpdateProfile("123", "123", "123", "123"));
    }
}