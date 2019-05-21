/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author Wagner Carestini
 * @param <T>
 */
public interface ytDAO<T>{
    
    public void update (T t);
    
    public void save(T t);
    
    public void delete(T t);
    
    List<T> selectAll();
    
    List<T> searchByName(T t);
    
}
