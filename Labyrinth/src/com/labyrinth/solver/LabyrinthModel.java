package com.labyrinth.solver;

/**
 * Created by Virgil Barcan on 08.03.2015.
 */
public interface LabyrinthModel {

    public int getRowCount();
    public int getColumnCount();
    public boolean isFreeAt();
    public int getStartCell();
    public int getFinishCell();

}
