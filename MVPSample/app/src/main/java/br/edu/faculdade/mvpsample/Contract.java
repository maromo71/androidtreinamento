package br.edu.faculdade.mvpsample;

public interface Contract {
    interface View {

        //método para mostrar a barra de progresso
        //quando o próximo curso for gerado.
        void showProgress();

        //método para ocultar a barra de progresso
        //quando o curso for exibido
        void hideProgress();

        //método para gerar o próximo texto no TextView
        void setString(String string);
    }

    interface Model{
        //interface aninhada
        interface OnFinishedListener{
            //função que será chamada
            //quando o manipulador da classe Model
            //completar sua execução
            void onFinished(String string);
        }

        void getNextCourse(Contract.Model.OnFinishedListener onFinishedListener);

    }

    interface Presenter{
        // método que será chamado quando o
        // botão for clicado
        void onButtonClick();

        // método que destroi o ciclo de
        //vida da MainActivity
        void onDestroy();

    }
}
