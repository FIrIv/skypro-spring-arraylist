package pro.sky.skyprospringarraylist.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringarraylist.services.StringArrayList;

@RestController
@RequestMapping("/strings")
public class StringArrayListController {

    private final StringArrayList stringArrayList;

    public StringArrayListController(StringArrayList stringArrayList) {
        this.stringArrayList = stringArrayList;
    }

    @GetMapping(path ="add", params = {"item"})
    public String addString (@RequestParam("item") String item) {
        return stringArrayList.add(item);
    }

    @GetMapping(path ="add-by-index", params = {"index", "item"})
    public String addStringByIndex (@RequestParam("index") int index, @RequestParam("item") String item) {
        return stringArrayList.add(index, item);
    }

    @GetMapping(path ="set-by-index", params = {"index", "item"})
    public String setStringByIndex (@RequestParam("index") int index, @RequestParam("item") String item) {
        return stringArrayList.set(index, item);
    }

    @GetMapping(path ="remove", params = {"item"})
    public String removeString (@RequestParam("item") String item) {
        return stringArrayList.remove(item);
    }

    @GetMapping(path ="remove-by-index", params = {"index"})
    public String removeStringByIndex (@RequestParam("index") int index) {
        return stringArrayList.remove(index);
    }

    @GetMapping(path ="contains", params = {"item"})
    public boolean containsString (@RequestParam("item") String item) {
        return stringArrayList.contains(item);
    }

    @GetMapping(path ="index-of", params = {"item"})
    public int indexOf (@RequestParam("item") String item) {
        return stringArrayList.indexOf(item);
    }

    @GetMapping(path ="lastindex-of", params = {"item"})
    public int lastIndexOf (@RequestParam("item") String item) {
        return stringArrayList.lastIndexOf(item);
    }

    @GetMapping(path ="get-by-index", params = {"index"})
    public String getStringByIndex (@RequestParam("index") int index) {
        return stringArrayList.get(index);
    }

    @GetMapping(path ="size")
    public int size () {
        return stringArrayList.size();
    }

    @GetMapping(path ="is-empty")
    public boolean isEmpty () {
        return stringArrayList.isEmpty();
    }

    @GetMapping(path ="clear")
    public void clear () {
        stringArrayList.clear();
    }

    @GetMapping(path ="to-array")
    public String [] toArray () {
        return stringArrayList.toArray();
    }
}
