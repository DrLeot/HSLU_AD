package ch.hslu.ad.Lists.SingleList;

import ch.hslu.ad.Memory.Allocation;

public final class Animal {

    private String name;

    public Animal(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof final Animal castedAnimal)){
            return false;
        }
        return (castedAnimal.name.equals(this.name));
    }
}
