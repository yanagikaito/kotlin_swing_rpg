package main

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KeyHandler(private var gamePanel: GamePanel) : KeyListener {

    private var upPressed = false

    private var downPressed = false

    private var leftPressed = false

    private var rightPressed = false

    init {

        this.gamePanel = gamePanel
    }

    override fun keyTyped(e: KeyEvent) {

    }

    override fun keyPressed(e: KeyEvent) {

        val code = e.keyCode

        if (code == KeyEvent.VK_W) {
            upPressed = true
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true
        }
    }

    override fun keyReleased(e: KeyEvent) {

        val code = e.keyCode

        if (code == KeyEvent.VK_W) {
            upPressed = false
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false
        }
    }
}