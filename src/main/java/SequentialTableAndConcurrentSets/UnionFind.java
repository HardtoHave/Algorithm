package SequentialTableAndConcurrentSets;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    public static class Element<V>{
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }
    public static class UnionFindSet<V>{
        public HashMap<V,Element<V>> elementMap;
        public HashMap<Element<V>,Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> sizeMap;
        public UnionFindSet(List<V> list){
            elementMap=new HashMap<>();
            fatherMap=new HashMap<>();
            sizeMap=new HashMap<>();
            for (V value:list){
                Element<V> element=new Element<V>(value);
                elementMap.put(value,element);
                fatherMap.put(element,element);
                sizeMap.put(element,1);
            }
        }
        public boolean isSameSet(V a,V b){
            if (elementMap.containsKey(a)&&elementMap.containsKey(b)){
                return findHead(elementMap.get(a))==findHead(elementMap.get(b));
            }
            return false;
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path=new Stack<>();
            while (element!=fatherMap.get(element)){
                path.push(element);
                element=fatherMap.get(element);
            }
            while (!path.isEmpty()){
                fatherMap.put(path.pop(),element);
            }
            return element;
        }
        public void union(V a,V b){
            if (elementMap.containsKey(a)&&elementMap.containsKey(b)){
                Element<V> aF=findHead(elementMap.get(a));
                Element<V> bF=findHead(elementMap.get(b));
                if (aF!=bF){
                    Element<V> big=sizeMap.get(aF)>=sizeMap.get(bF)?aF:bF;
                    Element<V> small=big==aF?bF:aF;
                    fatherMap.put(small,big);
                    sizeMap.put(big,sizeMap.get(aF)+sizeMap.get(bF));
                    sizeMap.remove(small);
                }
            }
        }
    }
}
