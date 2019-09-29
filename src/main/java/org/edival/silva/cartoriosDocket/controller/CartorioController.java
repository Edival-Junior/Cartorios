package org.edival.silva.cartoriosDocket.controller;

import java.util.List;

import org.edival.silva.cartoriosDocket.dao.CartorioDAO;
import org.edival.silva.cartoriosDocket.model.Cartorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@ResponseBody
public class CartorioController {
	
	@Autowired
	private CartorioDAO cartorioDao;
	
	@RequestMapping(value = {"/listarCartorios"}, method = RequestMethod.GET)
	public ModelAndView listarTodos() {
		ModelAndView modelAndView = new ModelAndView("cartorio");
		modelAndView.addObject("cartorios", cartorioDao.listarTodos());
		return modelAndView;
	}

	@RequestMapping(value = {"/cartorios"}, method = RequestMethod.GET)
	public List<Cartorio> listarTodosJson() {
		return cartorioDao.listarTodos();
	}
	
	@RequestMapping(value = {"/cadastrarCartorio"}, method = RequestMethod.GET)
	public ModelAndView salvar() {
		return new ModelAndView("cadastrarCartorio");
	}

	@RequestMapping(value = {"/salvar"}, method = RequestMethod.POST)
	public ModelAndView salvar(Cartorio cartorio) {
		cartorioDao.salvar(cartorio);
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = {"/editarCartorio"}, method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam(value="id", required = true) Long id) {
		ModelAndView modelAndView = new ModelAndView("cadastrarCartorio");
		modelAndView.addObject("cartorio", cartorioDao.buscarPorId(id));
		return modelAndView;
	}
	
	@RequestMapping(value = {"/editar"}, method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam(value="id", required = true) Long id, Cartorio cartorio) {
		cartorioDao.editar(cartorio, id);
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = {"/inativar"}, method = RequestMethod.GET)
	public ModelAndView inativar(@RequestParam(value="id", required = false) Long id) {
		cartorioDao.inativar(id);
		ModelAndView modelAndView = new ModelAndView("cartorio");
		modelAndView.addObject("cartorios", cartorioDao.listarTodos());
		return modelAndView;
	}
	
}
