package no.nav.bidrag.behandling.felles.grunnlag

import java.time.LocalDate

class BarnInfo(
    val datoFom: LocalDate,
    val datoTil: LocalDate?,
    val fnr: String,
    val navn: String?,
    val medIBeregning: Boolean?,
    val andelForsorget: Double?,
    val harSammeAdresse: Boolean?
) : IGrunnlagInnhold
