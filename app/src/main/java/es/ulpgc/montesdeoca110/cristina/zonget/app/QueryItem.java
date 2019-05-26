package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcelable;

@Entity(tableName = "queries",
        foreignKeys = @ForeignKey(
                entity = UserItem.class,
                parentColumns = "id",
                childColumns = "user_id"
        ))
public class QueryItem {

  @PrimaryKey
  public final int id;

  public final String sender;
  public final String title;
  public final String content;

  @ColumnInfo(name = "user_id")
  public int userId;


  //TODO añadir resto de propiedades: archivos?? cómo diablos metemos los archivos?

  public QueryItem(int id, String sender, String title, String content) {
    this.id = id;
    this.sender = sender;
    this.title = title;
    this.content = content;
  }
}
