package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.commands.ComplexCommand;
import edu.kis.powp.commands.DriverCommand;
import edu.kis.powp.commands.OperateToCommand;
import edu.kis.powp.commands.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class RectangleFactory implements ShapeFactory{

    private Job2dDriver job2dDriver;
    private int positionX;
    private int positionY;
    private final int a;
    private final int b;

    public RectangleFactory(Job2dDriver job2dDriver, int startX, int startY, int a, int b) {
        this.job2dDriver = job2dDriver;
        this.positionX = startX;
        this.positionY = startY;
        this.a = a;
        this.b = b;
    }

    @Override
    public ComplexCommand create() {
        List<DriverCommand> list = new ArrayList<DriverCommand>();
        list.add(new SetPositionCommand(job2dDriver, positionX, positionY));

        positionX = positionX + a;
        list.add(new OperateToCommand(job2dDriver, positionX, positionY));
        positionY = positionY + b;
        list.add(new OperateToCommand(job2dDriver, positionX, positionY));
        positionX = positionX - a;
        list.add(new OperateToCommand(job2dDriver, positionX, positionY));
        positionY = positionY - b;
        list.add(new OperateToCommand(job2dDriver, positionX, positionY));
        return new ComplexCommand(list);
    }

}
