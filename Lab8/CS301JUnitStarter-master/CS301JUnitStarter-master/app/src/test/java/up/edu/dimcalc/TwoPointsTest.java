package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 0);
        assertEquals(p1.y, 0);
        assertEquals(p2.x, 0);
        assertEquals(p2.y, 0);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 5);
        assertEquals(p1.y, -3);
        assertEquals(p2.x, -3);
        assertEquals(p2.y, 5);
    }

    @Test
    public void randomValue() {
        TwoPoints tPoints = new TwoPoints();
        //tPoints.randomValue(0);
        int x1 = tPoints.getPoint(0).x;
        int y1 = tPoints.getPoint(0).y;
        tPoints.randomValue(0);
        Point p1 = tPoints.getPoint(0);
        assertNotEquals(x1, p1.x);
        assertNotEquals(y1, p1.y);
    }

    @Test
    public void setOrigin() {
        TwoPoints tPoints = new TwoPoints();
        tPoints.setPoint(0, 1,1);
        tPoints.setOrigin(0);
        Point p1 = tPoints.getPoint(0);
        assertEquals(p1.x, 0);
        assertEquals(p1.y, 0);

    }

    @Test
    public void copy() {
        TwoPoints tPoints = new TwoPoints();
        tPoints.setPoint(0, 1, 1);
        //tPoints.randomValue(1);
        tPoints.copy(0,1);
        assertEquals(tPoints.getPoint(0).x, tPoints.getPoint(1).x);
        assertEquals(tPoints.getPoint(0).y, tPoints.getPoint(1).y);
        tPoints.setOrigin(0);
        assertNotEquals(tPoints.getPoint(0).x, tPoints.getPoint(1).x);
        assertNotEquals(tPoints.getPoint(0).x, tPoints.getPoint(1).x);
    }

    @Test
    public void distance() {
        TwoPoints twoPoints = new TwoPoints();
        twoPoints.setPoint(1, 3, 0);
        double dist = twoPoints.distance();
        assertEquals(dist, 3.0, .000000001);
    }

    @Test
    public void slope() {
        TwoPoints tPoints = new TwoPoints();
        tPoints.setPoint(1, 2,1);
        double slope = tPoints.slope();
        assertEquals(slope, 0.5, .000000001);
    }
}