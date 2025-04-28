package br.futurodev.joiville.m1s09exercicios.errors.exeptions;

public class ElectronicWasteNotFoundException extends NotFoundException {
    public ElectronicWasteNotFoundException(Long id) {
        super("Electronic waste", id);
    }
}
