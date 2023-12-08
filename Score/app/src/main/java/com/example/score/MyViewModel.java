package com.example.score;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;
    private int aBack,bBack;
    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore==null){
            aTeamScore=new MutableLiveData<>();
            aTeamScore.setValue(0);
            return aTeamScore;
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore==null){
           bTeamScore=new MutableLiveData<>();
            bTeamScore.setValue(0);
            return bTeamScore;
        }
        return bTeamScore;
    }
    public void aTeamAdd(int a){
        aBack=aTeamScore.getValue();
        bBack=bTeamScore.getValue();
        aTeamScore.setValue( a + aTeamScore.getValue());
    }
    public void bTeamAdd(int a){
        aBack=aTeamScore.getValue();
        bBack=bTeamScore.getValue();
        bTeamScore.setValue( a + bTeamScore.getValue());
    }
    public void undo(){
        aTeamScore.setValue(aBack);
        bTeamScore.setValue(bBack);
    }
    public void reset(){
        aBack=aTeamScore.getValue();
        bBack=bTeamScore.getValue();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }

}
