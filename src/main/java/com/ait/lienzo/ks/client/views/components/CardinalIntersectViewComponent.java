/*
   Copyright (c) 2014,2015 Ahome' Innovation Technologies. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.ait.lienzo.ks.client.views.components;

import com.ait.lienzo.client.core.shape.Circle;
import com.ait.lienzo.client.core.shape.Group;
import com.ait.lienzo.client.core.shape.Layer;
import com.ait.lienzo.client.core.shape.MultiPath;
import com.ait.lienzo.client.core.types.BoundingBox;
import com.ait.lienzo.client.core.types.PathPartList;
import com.ait.lienzo.client.core.types.Point2D;
import com.ait.lienzo.client.core.types.Point2DArray;
import com.ait.lienzo.client.core.util.Geometry;
import com.ait.lienzo.ks.client.ui.components.KSButton;
import com.ait.lienzo.ks.client.views.AbstractToolBarViewComponent;
import com.ait.toolkit.sencha.ext.client.events.button.ClickEvent;
import com.ait.toolkit.sencha.ext.client.events.button.ClickHandler;

public class CardinalIntersectViewComponent extends AbstractToolBarViewComponent
{
    private final KSButton m_bound = new KSButton("Bounds");

    public CardinalIntersectViewComponent()
    {
        final Layer layer = new Layer();

        m_bound.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
            }
        });
        m_bound.setWidth(90);

        getToolBarContainer().add(m_bound);

        Group g = new Group();

        g.setX(15);

        g.setY(-100);

        layer.add(g);

        boundingBoxWithLineIntersect(g);

        g = new Group();

        g.setX(-60);

        g.setY(450);

        layer.add(g);

        cardinalIntersectionPoints(g);

        getLienzoPanel().add(layer);

        getLienzoPanel().setBackgroundLayer(getBackgroundLayer());

        getWorkingContainer().add(getLienzoPanel());
    }

    public void cardinalIntersectionPoints(Group container)
    {
        // clockwise
        MultiPath path = new MultiPath();
        Group g = new Group();
        g.setX(50);
        g.setY(20);
        container.add(g);
        path.M(100, 0);
        path.A(150, 0, 150, 50, 50);
        path.A(150, 100, 100, 100, 50);
        path.A(50, 100, 50, 50, 50);
        path.A(50, 0, 100, 0, 50);
        drawPath(path, g);

        path = new MultiPath();
        g = new Group();
        g.setX(200);
        g.setY(20);
        container.add(g);
        path.M(100, 0);
        path.A(150, 0, 150, 50, 50);
        path.L(150, 100);
        path.L(50, 100);
        path.L(50, 0);
        path.L(100, 0);
        drawPath(path, g);

        path = new MultiPath();
        g = new Group();
        g.setX(350);
        g.setY(20);
        container.add(g);
        path.M(100, 0);
        path.L(150, 0);
        path.L(150, 50);
        path.A(150, 100, 100, 100, 50);
        path.L(50, 100);
        path.L(50, 0);
        path.L(100, 0);
        drawPath(path, g);

        path = new MultiPath();
        g = new Group();
        g.setX(500);
        g.setY(20);
        container.add(g);
        path.M(100, 0);
        path.L(150, 0);
        path.L(150, 100);
        path.A(50, 100, 50, 50, 50);
        path.L(50, 0);
        path.L(100, 0);
        drawPath(path, g);

        path = new MultiPath();
        g = new Group();
        g.setX(650);
        g.setY(20);
        container.add(g);
        path.M(100, 0);
        path.L(150, 0);
        path.L(150, 100);
        path.L(50, 100);
        path.L(50, 50);
        path.A(50, 0, 100, 0, 50);
        drawPath(path, g);

        // counterclockwise
        path = new MultiPath();
        g = new Group();
        g.setX(50);
        g.setY(150);
        container.add(g);
        path.M(100, 0);
        path.A(50, 0, 50, 50, 50);
        path.A(50, 100, 100, 100, 50);
        path.A(150, 100, 150, 50, 50);
        path.A(150, 0, 100, 0, 50);
        drawPath(path, g);

        path = new MultiPath();
        g = new Group();
        g.setX(200);
        g.setY(150);
        container.add(g);
        path.M(100, 0);
        path.A(50, 0, 50, 50, 50);
        path.L(50, 100);
        path.L(150, 100);
        path.L(150, 0);
        path.L(100, 0);
        drawPath(path, g);

        path = new MultiPath();
        g = new Group();
        g.setX(350);
        g.setY(150);
        container.add(g);
        path.M(100, 0);
        path.L(50, 0);
        path.L(50, 50);
        path.A(50, 100, 100, 100, 50);
        path.L(150, 100);
        path.L(150, 0);
        path.L(100, 0);
        drawPath(path, g);

        path = new MultiPath();
        g = new Group();
        g.setX(500);
        g.setY(150);
        container.add(g);
        path.M(100, 0);
        path.L(50, 0);
        path.L(50, 100);
        path.L(100, 100);
        path.A(150, 100, 150, 50, 50);
        path.L(150, 0);
        path.L(100, 0);
        drawPath(path, g);

        path = new MultiPath();
        g = new Group();
        g.setX(650);
        g.setY(150);
        container.add(g);
        path.M(100, 0);
        path.L(50, 0);
        path.L(50, 100);
        path.L(150, 100);
        path.L(150, 50);
        path.A(150, 0, 100, 0, 50);
        path.L(100, 0);
        drawPath(path, g);

        // inner and out paths
        path = new MultiPath();
        g = new Group();
        g.setX(50);
        g.setY(300);
        container.add(g);
        path.M(100, 0);
        path.L(50, 0);
        path.L(50, 100);
        path.L(150, 100);
        path.L(150, 0);
        path.L(100, 0);
        path.L(100, 20);
        path.L(70, 20);
        path.L(70, 80);
        path.L(130, 80);
        path.L(130, 20);
        path.L(100, 20);
        drawPath(path, g);

        path = new MultiPath();
        g = new Group();
        g.setX(200);
        g.setY(300);
        container.add(g);
        path.M(100, 0);
        path.A(150, 0, 150, 50, 50);
        path.A(150, 100, 100, 100, 50);
        path.A(50, 100, 50, 50, 50);
        path.A(50, 0, 100, 0, 50);
        path.L(100, 20);
        path.A(130, 20, 130, 45, 30);
        path.A(130, 80, 100, 80, 30);
        path.A(70, 80, 70, 45, 30);
        path.A(70, 20, 100, 20, 30);
        drawPath(path, g);
    }

    private void drawPath(MultiPath path, Group g)
    {
        g.add(path);
        PathPartList list = path.getPathPartListArray().get(0);
        Point2D[] array = Geometry.getCardinalIntersects(list);
        for (Point2D p : array)
        {
            if (p != null)
            {
                drawCircle(g, p);
            }
        }
    }

    public void boundingBoxWithLineIntersect(Group container)
    {
        Group g = new Group();
        g.setX(25);
        container.add(g);
        Point2D arc0 = new Point2D(0, 200);
        Point2D arc1 = new Point2D(100, 0);
        Point2D arc2 = new Point2D(200, 200);
        Point2D lineStart = new Point2D(-10, 130);
        Point2D lineEnd = new Point2D(200, 160);
        double radius = 100;
        drawArcWithLineIntersect(g, arc0, arc1, arc2, lineStart, lineEnd, radius);

        g = new Group();
        g.setX(25);
        g.setX(250);
        container.add(g);
        arc0 = new Point2D(200, 200);
        arc1 = new Point2D(100, 0);
        arc2 = new Point2D(0, 200);
        lineStart = new Point2D(0, 130);
        lineEnd = new Point2D(210, 180);
        radius = 100;
        drawArcWithLineIntersect(g, arc0, arc1, arc2, lineStart, lineEnd, radius);

        g = new Group();
        g.setY(250);
        g.setX(25);
        container.add(g);
        arc0 = new Point2D(0, 0);
        arc1 = new Point2D(100, 200);
        arc2 = new Point2D(200, 0);
        lineStart = new Point2D(-30, 0);
        lineEnd = new Point2D(200, 60);
        radius = 100;
        drawArcWithLineIntersect(g, arc0, arc1, arc2, lineStart, lineEnd, radius);

        g = new Group();
        g.setY(250);
        g.setX(250);
        container.add(g);
        arc0 = new Point2D(200, 0);
        arc1 = new Point2D(100, 200);
        arc2 = new Point2D(0, 0);
        lineStart = new Point2D(-10, 30);
        lineEnd = new Point2D(210, 70);
        radius = 100;
        drawArcWithLineIntersect(g, arc0, arc1, arc2, lineStart, lineEnd, radius);

        g = new Group();
        g.setX(75);
        g.setY(300);
        container.add(g);
        arc0 = new Point2D(0, 50);
        arc1 = new Point2D(50, 0);
        arc2 = new Point2D(100, 100);
        lineStart = new Point2D(-60, 55);
        lineEnd = new Point2D(125, 110);
        radius = 100;
        drawArcWithLineIntersect(g, arc0, arc1, arc2, lineStart, lineEnd, radius);

        g = new Group();
        g.setX(275);
        g.setY(325);
        container.add(g);
        arc0 = new Point2D(130, 30);
        arc1 = new Point2D(100, -50);
        arc2 = new Point2D(50, 0);
        lineStart = new Point2D(-20, 40);
        lineEnd = new Point2D(200, 60);
        radius = 100;
        drawArcWithLineIntersect(g, arc0, arc1, arc2, lineStart, lineEnd, radius);

        g = new Group();
        g.setX(75);
        g.setY(475);
        container.add(g);
        arc0 = new Point2D(0, 50);
        arc1 = new Point2D(50, 100);
        arc2 = new Point2D(100, 0);
        lineStart = new Point2D(-60, 40);
        lineEnd = new Point2D(125, 0);
        radius = 100;
        drawArcWithLineIntersect(g, arc0, arc1, arc2, lineStart, lineEnd, radius);

        g = new Group();
        g.setX(320);
        g.setY(490);
        container.add(g);
        arc0 = new Point2D(80, 30);
        arc1 = new Point2D(50, 100);
        arc2 = new Point2D(0, 50);
        lineStart = new Point2D(-60, 20);
        lineEnd = new Point2D(125, 0);
        radius = 100;
        drawArcWithLineIntersect(g, arc0, arc1, arc2, lineStart, lineEnd, radius);
    }

    private void drawArcWithLineIntersect(Group g, Point2D arc0, Point2D arc1, Point2D arc2, Point2D lineStart, Point2D lineEnd, double radius)
    {
        MultiPath path = new MultiPath();

        path.M(arc0);
        path.A(arc1.getX(), arc1.getY(), arc2.getX(), arc2.getY(), radius);
        g.add(path);

        BoundingBox box = Geometry.getBoundingBoxOfArcTo(arc0, arc1, arc2, radius);

        path = new MultiPath();
        path.M(box.getX(), box.getY());
        path.L(box.getX() + box.getWidth(), box.getY());
        path.L(box.getX() + box.getWidth(), box.getY() + box.getHeight());
        path.L(box.getX(), box.getY() + box.getHeight());
        path.L(box.getX(), box.getY());
        g.add(path);

        path = new MultiPath();
        path.M(lineStart);
        path.L(lineEnd);
        g.add(path);

        Point2DArray points = Geometry.intersectLineArcTo(lineStart, lineEnd, arc0, arc1, arc2, radius);

        for (int i = 0; i < points.size(); i++)
        {
            drawCircle(g, points.get(i));
        }
    }

    private void drawCircle(Group container, Point2D p)
    {
        Circle circle = new Circle(3);
        circle.setLocation(p);
        circle.setFillColor("#CC0000");
        circle.setStrokeColor("#CC0000");
        container.add(circle);
    }
}