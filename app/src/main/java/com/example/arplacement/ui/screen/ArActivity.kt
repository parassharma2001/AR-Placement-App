package com.example.arplacement.ui.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.arplacement.R
import com.google.ar.core.Anchor
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.Color
import com.google.ar.sceneform.rendering.MaterialFactory
import com.google.ar.sceneform.rendering.ShapeFactory
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class ArActivity : AppCompatActivity() {

    private lateinit var arFragment: ArFragment
    private var drillPlaced = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar)

        // Find the AR fragment from XML
        arFragment = supportFragmentManager.findFragmentById(R.id.arFragment) as ArFragment

        // Handle tap on detected plane
        arFragment.setOnTapArPlaneListener { hitResult, _, _ ->
            if (!drillPlaced) {
                val anchor: Anchor = hitResult.createAnchor()
                placeObject(anchor)
                drillPlaced = true
            }
        }
    }

    private fun placeObject(anchor: Anchor) {
        // Create a red opaque material
        MaterialFactory.makeOpaqueWithColor(this, Color(android.graphics.Color.RED))
            .thenAccept { material ->
                // Create a cube (0.1m x 0.1m x 0.1m)
                val cubeRenderable = ShapeFactory.makeCube(
                    Vector3(0.1f, 0.1f, 0.1f),  // size
                    Vector3(0f, 0.05f, 0f),     // center offset (Y is half the height)
                    material
                )

                // Anchor in AR scene
                val anchorNode = AnchorNode(anchor)
                anchorNode.setParent(arFragment.arSceneView.scene)

                // Add transformable cube to scene
                val node = TransformableNode(arFragment.transformationSystem)
                node.renderable = cubeRenderable
                node.setParent(anchorNode)
            }
    }
}
