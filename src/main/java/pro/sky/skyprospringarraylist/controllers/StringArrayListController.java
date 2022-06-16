package pro.sky.skyprospringarraylist.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringarraylist.services.StringArrayListService;

@RestController
@RequestMapping("/strings")
public class StringArrayListController {

    private final StringArrayListService stringArrayListService;

    public StringArrayListController(StringArrayListService stringArrayListService) {
        this.stringArrayListService = stringArrayListService;
    }

    @GetMapping(path ="add", params = {"item"})
    public String addString (@RequestParam("item") String item) {
        return stringArrayListService.add(item);
    }

    @GetMapping(path ="add-by-index", params = {"index", "item"})
    public String addStringByIndex (@RequestParam("index") int index, @RequestParam("item") String item) {
        return stringArrayListService.add(index, item);
    }

    @GetMapping(path ="set-by-index", params = {"index", "item"})
    public String setStringByIndex (@RequestParam("index") int index, @RequestParam("item") String item) {
        return stringArrayListService.set(index, item);
    }

    @GetMapping(path ="remove", params = {"item"})
    public String removeString (@RequestParam("item") String item) {
        return stringArrayListService.remove(item);
    }

    @GetMapping(path ="remove-by-index", params = {"index"})
    public String removeStringByIndex (@RequestParam("index") int index) {
        return stringArrayListService.remove(index);
    }

    @GetMapping(path ="contains", params = {"item"})
    public boolean containsString (@RequestParam("item") String item) {
        return stringArrayListService.contains(item);
    }

    @GetMapping(path ="index-of", params = {"item"})
    public int indexOf (@RequestParam("item") String item) {
        return stringArrayListService.indexOf(item);
    }

    @GetMapping(path ="lastindex-of", params = {"item"})
    public int lastIndexOf (@RequestParam("item") String item) {
        return stringArrayListService.lastIndexOf(item);
    }

    @GetMapping(path ="get-by-index", params = {"index"})
    public String getStringByIndex (@RequestParam("index") int index) {
        return stringArrayListService.get(index);
    }

    @GetMapping(path ="size")
    public int size () {
        return stringArrayListService.size();
    }

    @GetMapping(path ="is-empty")
    public boolean isEmpty () {
        return stringArrayListService.isEmpty();
    }

    @GetMapping(path ="clear")
    public void clear () {
        stringArrayListService.clear();
    }

    @GetMapping(path ="to-array")
    public String [] toArray () {
        return stringArrayListService.toArray();
    }
}
