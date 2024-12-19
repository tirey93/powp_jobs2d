package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.commands.ComplexCommand;
import edu.kis.powp.commands.DriverCommand;
import edu.kis.powp.commands.OperateToCommand;
import edu.kis.powp.commands.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class TriangleFactory implements ShapeFactory{

    private Job2dDriver job2dDriver;
    private double positionX;
    private double positionY;
    private final double side;

    public TriangleFactory(Job2dDriver job2dDriver, double startX, double startY, double side) {
        this.job2dDriver = job2dDriver;
        this.positionX = startX;
        this.positionY = startY;
        this.side = side;
    }

    @Override
    public ComplexCommand create() {
        List<DriverCommand> list = new ArrayList<>();

        double A_x = positionX;
        double A_y = positionY;

        list.add(new SetPositionCommand(job2dDriver,(int) Math.round(A_x),(int) Math.round(A_y)));


        double angleB = 120;
        double B_x = A_x + side * Math.cos(Math.toRadians(angleB));
        double B_y = A_y + side * Math.sin(Math.toRadians(angleB));

        list.add(new OperateToCommand(job2dDriver,(int) Math.round(B_x),(int) Math.round(B_y)));

        double angleC = -120;
        double C_x = A_x + side * Math.cos(Math.toRadians(angleC));
        double C_y = A_y + side * Math.sin(Math.toRadians(angleC));

        list.add(new OperateToCommand(job2dDriver,(int) Math.round(C_x),(int) Math.round(C_y)));

        list.add(new OperateToCommand(job2dDriver,(int) Math.round(A_x),(int) Math.round(A_y)));


        return new ComplexCommand(list);
    }

}
