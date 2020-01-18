package br.edu.ifal.listacompras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListaComprasController {

    @Autowired
    private ItemRepository repo;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/listacompras")
    public ModelAndView listaCompras() {
        ModelAndView mv = new ModelAndView("listacompras");
        mv.addObject("itens", repo.findAll());
        return mv;
    }

    @RequestMapping("/listacompras/cadastro")
    public ModelAndView cadastro(Item item) {
        ModelAndView mv = new ModelAndView("redirect:/listacompras");
        repo.save(item);
        return mv;
    }

    @RequestMapping("/listacompras/excluir/{id}")
    public ModelAndView excluir(@PathVariable(name = "id") long id) {
        ModelAndView mv = new ModelAndView("redirect:/listacompras");
        repo.deleteById(id);
        return mv;
    }

}