package Services;

import Models.Store;

import java.util.List;
@SuppressWarnings("unused")
public interface GenericService<Type> {
    List<Type> GetAll();
    void SaveIntoCSV();

    void ReadFromCSV();

    void SaveIntoDB();

    void ReadFromDB();
}
