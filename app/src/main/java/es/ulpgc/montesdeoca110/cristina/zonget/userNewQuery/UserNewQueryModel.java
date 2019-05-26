package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserNewQueryModel implements UserNewQueryContract.Model {

  private RepositoryContract.Queries repository;

  public UserNewQueryModel(RepositoryContract.Queries repository) {
    this.repository = repository;
  }

  @Override
  public void fetchUserNewQueryData() {}

  @Override
  public void setNewQuery(int userId, String title, String content, RepositoryContract.Queries.SetNewQueryCallback callback) {
    repository.setNewQuery(userId,title,content,callback);
  }


}
