package br.futurodev.joiville.m1s09exercicios.errors.exeptions;

public class CollectionPointNotFoundException extends NotFoundException {
    public CollectionPointNotFoundException(Long id) {
        super("Collection point", id);
    }
}
