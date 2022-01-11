package br.edu.faculdade.mvpsample;

public class Presenter implements Contract.Presenter,
        Contract.Model.OnFinishedListener{
    // criando objeto mainView da Interface View
    private Contract.View mainView;

    // criando objeto da Interface Model
    private Contract.Model model;


    // instanciando os objetos da View e da Model
    public Presenter(Contract.View mainView, Contract.Model model) {
        this.mainView = mainView;
        this.model = model;
    }

    @Override
    // método para retornar a string
    // que será exibida na TextView de
    // detalhes do curso
    public void onFinished(String string) {
        if (mainView != null) {
            mainView.setString(string);
            mainView.hideProgress();
        }
    }

    @Override
    // operações a serem executadas no clique do botão
    public void onButtonClick() {
        if (mainView != null) {
            mainView.showProgress();
        }
        model.getNextCourse(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }
}
