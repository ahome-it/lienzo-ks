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

import com.ait.lienzo.charts.client.core.model.DataTable;
import com.ait.lienzo.charts.client.core.model.DataTableColumn.DataTableColumnType;
import com.ait.lienzo.charts.client.core.model.PieChartData;
import com.ait.lienzo.charts.client.core.pie.PieChart;
import com.ait.lienzo.charts.client.core.pie.event.ValueSelectedEvent;
import com.ait.lienzo.charts.client.core.pie.event.ValueSelectedHandler;
import com.ait.lienzo.client.core.shape.Layer;
import com.ait.lienzo.ks.client.views.AbstractViewComponent;

public class PieChartViewComponent extends AbstractViewComponent
{
    public PieChartViewComponent()
    {
        final Layer layer = new Layer();

        final DataTable table = buildPieChartDataTable();

        final PieChartData data = new PieChartData(table, "product", "quantity");

        final PieChart pc = new PieChart();

        pc.setName("Products availability").setX(25).setY(25);

        pc.setData(data).setWidth(500).setHeight(500).setFontFamily("Verdana").setFontStyle("bold").setFontSize(12).setResizable(true).draw();

        pc.addValueSelectedHandler(new ValueSelectedHandler()
        {
            @Override
            public void onValueSelected(ValueSelectedEvent event)
            {
                pc.setData(new PieChartData(table, "product_2", "quantity_2"));
            }
        });
        layer.add(pc);

        getLienzoPanel().add(layer);

        getLienzoPanel().setBackgroundLayer(getBackgroundLayer());

        getWorkingContainer().add(getLienzoPanel());
    }

    protected DataTable buildPieChartDataTable()
    {
        final DataTable table = new DataTable();

        table.addColumn("product", DataTableColumnType.STRING);

        table.addColumn("product_2", DataTableColumnType.STRING);

        table.addColumn("quantity", DataTableColumnType.NUMBER);

        table.addColumn("quantity_2", DataTableColumnType.NUMBER);

        table.addValue("product", "Shoes");

        table.addValue("product", "Shirts");

        table.addValue("product", "Socks");

        table.addValue("product", "Jeans");

        table.addValue("product", "Ties");

        table.addValue("product_2", "Apples");

        table.addValue("product_2", "Oranges");

        table.addValue("product_2", "Pears");

        table.addValue("product_2", "Grapes");

        table.addValue("quantity", 50);

        table.addValue("quantity", 80);

        table.addValue("quantity", 30);

        table.addValue("quantity", 70);

        table.addValue("quantity", 30);

        table.addValue("quantity_2", 30);

        table.addValue("quantity_2", 70);

        table.addValue("quantity_2", 80);

        table.addValue("quantity_2", 30);

        return table;
    }
}
