package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "queryStatus")
public class QueryStatusItem {

    @PrimaryKey
    private int id;
}
