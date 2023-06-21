package fr.doranco.flash.database;

import android.content.Context;
import android.util.Log;

import fr.doranco.flash.dao.SpecialiteDao;
import fr.doranco.flash.entity.Specialite;

public class SpecialiteDatabaseTest extends Thread{
    private final DaoFactory daoFactory;
    private final SpecialiteDao specialiteDao;

    public SpecialiteDatabaseTest (Context context){
        daoFactory = DaoFactory.getInstance(context);
        specialiteDao =daoFactory.getSpecialiteDao();
    }

    @Override
    public void run() {
        super.run();
        // creation des objets
        Specialite specialite1 = new Specialite("Securite informatique");
        Specialite specialite2 = new Specialite("Systeme information");
        Specialite specialite3 = new Specialite("Dev web JAVA");
        Specialite specialite4 = new Specialite("DevOps");
        Specialite specialite5 = new Specialite("Machine Learning");

        // enregistrement en BD
        SpecialiteDao.create(specialite1);
        SpecialiteDao.create(specialite2);
        SpecialiteDao.create(specialite3);
        SpecialiteDao.create(specialite4);
        SpecialiteDao.create(specialite5);
        Log.i("log-bd","Création effectuée avec succès");
        // lister toutes les specialites
        Log.i("log-bd", specialiteDao.readAll().toString());
        specialite3 = specialiteDao.findById(3);
        specialite3.setNom("Dev Fullstack Java");
        specialiteDao.update(specialite3);
        // delete specialité 5
        specialite5 = specialiteDao.findById(5);
        specialiteDao.delete(specialite5);
        // lister toutes les specialites
        Log.i("log-bd", specialiteDao.readAll().toString());
    }
}
