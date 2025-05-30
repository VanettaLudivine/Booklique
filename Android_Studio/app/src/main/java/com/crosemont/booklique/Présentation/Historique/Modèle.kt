package com.crosemont.booklique.Présentation.Historique

import Livre
import android.content.Context
import com.crosemont.booklique.sourcededonnées.dao.dbConfig.DatabaseBuilder
import com.crosemont.booklique.domaine.entité.Reservation
import com.crosemont.booklique.domaine.entité.ReservationHistorique
import com.crosemont.booklique.domaine.service.LivreService
import com.crosemont.booklique.domaine.service.ReservationService

class Modèle(context: Context){

    private val database = DatabaseBuilder.obtenirInstance(context)
    private val reservationHistoriqueDao = database.reservationHistoriqueDao()

    suspend fun obtenirHistoriqueReservation(): List<ReservationHistorique> {
        return reservationHistoriqueDao.obtenirToutesLesReservations()
    }

    suspend fun supprimerHistoriqueReservation(){
        reservationHistoriqueDao.supprimerToutesLesReservations()
    }

    fun obtenirLivreParIsbn(isbn: String): Livre? {
        return LivreService.obtenirLivreParISBN(isbn)
    }

    fun obtenirReservation(): List<Reservation> {
        return ReservationService.obtenirReservations()
    }
}