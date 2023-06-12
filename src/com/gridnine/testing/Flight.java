package com.gridnine.testing;

import java.util.List;

public class Flight {
    private final List<Segment> segments;

    public Flight(List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Flight");
        for (Segment segment : segments) {
            sb.append("\n  ").append(segment);
        }
        return sb.toString();
    }
}
